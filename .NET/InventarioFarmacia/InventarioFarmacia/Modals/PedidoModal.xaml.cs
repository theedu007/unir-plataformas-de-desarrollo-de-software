using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;
using InventarioFarmacia.DTOS;

namespace InventarioFarmacia.Modals
{
    /// <summary>
    /// Interaction logic for PedidoModal.xaml
    /// </summary>
    public partial class PedidoModal : Window
    {
        public PedidoModal(PedidoDto pedido)
        {
            InitializeComponent();

            Title = $"Pedido al proveedor {pedido.Distribuidor}";

            var stringbuilder = new StringBuilder();
            stringbuilder.AppendLine($"{pedido.CantidadMedicamento} unidades del " +
                                     $"{pedido.TipoMedicamento} " +
                                     $"{pedido.NombreMedicamento}");

            stringbuilder.AppendLine();

            for (int i = 0; i < pedido.Sucursales.Count; i++)
            {
                if (i > 0)
                {
                    stringbuilder.AppendLine($" y para la situada en {pedido.Sucursales[i]}");
                }
                else
                {
                    stringbuilder.AppendLine($"Para la farmacia situada en {pedido.Sucursales[i]}");
                }
            }

            textBlock.Text = stringbuilder.ToString();
        }

        private void button_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }

        private void button1_Click(object sender, RoutedEventArgs e)
        {
            MessageBox.Show("Pedido enviado");
            Close();
        }
    }
}
