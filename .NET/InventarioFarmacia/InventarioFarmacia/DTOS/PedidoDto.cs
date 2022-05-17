using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace InventarioFarmacia.DTOS
{
    public class PedidoDto
    {
        public string NombreMedicamento { get; set; }
        public string TipoMedicamento { get; set; }
        public int CantidadMedicamento { get; set; }
        public string Distribuidor { get; set; }
        public List<string> Sucursales { get; set; } = new List<string>();
    }
}
