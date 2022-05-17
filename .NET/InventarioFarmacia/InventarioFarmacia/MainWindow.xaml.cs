using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;
using InventarioFarmacia.DTOS;
using InventarioFarmacia.Modals;

namespace InventarioFarmacia
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
            
        }

        private List<string> ValidarInputs()
        {
            var errores = new List<string>();

            if (string.IsNullOrEmpty(txtNombreMedicamento.Text))
                errores.Add("El nombre del medicamento no puede estar vacio");

            if (cmbBoxTipoMedicamento.SelectedIndex == 0)
                errores.Add("No se ha seleccionado un tipo de medicamento");

            var patronRegex = new Regex("^[a-zA-Z0-9 ]*$");
            if (!patronRegex.IsMatch(txtNombreMedicamento.Text))
                errores.Add("El nombre del medicamento solo debe contener caracteres alfanumericos");

            if (int.TryParse(txtCantidadProducto.Text, out var num))
            {
                if (num == 0)
                    errores.Add("La cantidad de medicamento no puede ser cero");
                if (num < 0)
                    errores.Add("El numero debe ser un entero positivo");
            }
            else
            {
                errores.Add("La cantidad de medicamento no es un numero valido");
            }


            var cemefarIsChecked = rdBtnCemefar.IsChecked.GetValueOrDefault();
            var cofarmaIsChecked = rdBtnCofarma.IsChecked.GetValueOrDefault();
            var empsefarIsChecked = rdBtnEmpsefar.IsChecked.GetValueOrDefault();
            
            if(!cemefarIsChecked && !cofarmaIsChecked && !empsefarIsChecked) 
            {
                errores.Add("No se ha seleccionado un proveedor");
            }

            var sucursalPrincipalIsSelected = chBoxPrincipal.IsChecked.GetValueOrDefault();
            var sucursalSecundariaIsSelected = chBoxSecundaria.IsChecked.GetValueOrDefault();

            if (!sucursalPrincipalIsSelected && !sucursalSecundariaIsSelected)
            {
                errores.Add("No se ha seleccionado una sucursal");
            }

            return errores;
        }

        private PedidoDto ObtenerPedido()
        {
            PedidoDto pedido = new PedidoDto();

            pedido.NombreMedicamento = txtNombreMedicamento.Text;
            pedido.CantidadMedicamento = int.Parse(txtCantidadProducto.Text);

            var medicamentoSeleccionado = cmbBoxTipoMedicamento.SelectedItem as ComboBoxItem;
            pedido.TipoMedicamento = medicamentoSeleccionado.Content.ToString();

            if(chBoxPrincipal.IsChecked.HasValue && chBoxPrincipal.IsChecked.Value)
                pedido.Sucursales.Add("Calle de la Rosa n. 28");

            if (chBoxSecundaria.IsChecked.HasValue && chBoxSecundaria.IsChecked.Value)
                pedido.Sucursales.Add("Calle Alcazabilla n. 3");

            return pedido;
        }

        private void btnAceptar_Click(object sender, RoutedEventArgs e)
        {
            var errores = ValidarInputs();

            if (errores.Any())
            {
                var errorModal = new ErrorModal(errores);
                errorModal.Focus();
                errorModal.ShowDialog();
            }
            else
            {
                var pedido = ObtenerPedido();
                var pedidoModal = new PedidoModal(pedido);
                pedidoModal.Focus();
                pedidoModal.ShowDialog();
            }
        }

        private void btnCancelar_Click(object sender, RoutedEventArgs e)
        {
            txtNombreMedicamento.Text = string.Empty;
            txtCantidadProducto.Text = string.Empty;
            cmbBoxTipoMedicamento.SelectedIndex = 0;
            rdBtnCemefar.IsChecked = false;
            rdBtnCofarma.IsChecked = false;
            rdBtnEmpsefar.IsChecked = false;
            chBoxPrincipal.IsChecked = false;
            chBoxSecundaria.IsChecked = false;
        }
    }
}
