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

namespace InventarioFarmacia.Modals
{
    /// <summary>
    /// Interaction logic for ErrorModal.xaml
    /// </summary>
    public partial class ErrorModal : Window
    {
        public ErrorModal(List<string> errores)
        {
            InitializeComponent();
            MostrarErrores(errores);
        }

        private void MostrarErrores(List<string> errores)
        {
            var stringBuilder = new StringBuilder();
            stringBuilder.AppendLine("Por favor corriga los siguientes errores en el formulario:");

            foreach (var error in errores)
            {
                stringBuilder.AppendLine($"\t\x2022 {error}");
            }

            txtBlock.Text = stringBuilder.ToString();
        }

        private void button_Click(object sender, RoutedEventArgs e)
        {
            Close();
        }
    }
}
