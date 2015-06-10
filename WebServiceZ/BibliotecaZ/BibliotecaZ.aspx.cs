using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace BibliotecaZ
{
    public partial class BibliotecaZ : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            LlenarComboBoxFiltro();
        }

        public void LlenarComboBoxFiltro()
        {
            comboFiltro.Items.Add("ISBN");
            comboFiltro.Items.Add("Titulo");
            comboFiltro.Items.Add("Autor");
        }
    }
}