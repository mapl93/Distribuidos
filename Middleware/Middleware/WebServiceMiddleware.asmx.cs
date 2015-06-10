using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using System.Xml;

namespace Middleware
{
    /// <summary>
    /// Summary description for WebServiceMiddleware
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WebServiceMiddleware : System.Web.Services.WebService
    {
        String xmlZPath = "C:\\Users\\MAPL\\Documents\\Visual Studio 2013\\Projects\\Middleware\\Middleware\\data\\CatalogoZ.xml";
        String xmlYPath = "C:\\Users\\MAPL\\Documents\\Visual Studio 2013\\Projects\\Middleware\\Middleware\\data\\CatalogoY.xml";
        String xmlSPath = "C:\\Users\\MAPL\\Documents\\Visual Studio 2013\\Projects\\Middleware\\Middleware\\data\\CatalogoS.xml";

        [WebMethod]
        public String[] ObtenerInformacion(String busqueda, String filtro, String biblioteca)
        {
            String[] articulo = new String[4];
            articulo[0] = "NO EXISTE";
            articulo[1] = "NO EXISTE";
            articulo[2] = "NO EXISTE";
            articulo[3] = "";
            XmlTextReader reader;

            if (biblioteca.Equals("Z"))
            {
                reader = new XmlTextReader(xmlZPath);
                articulo[3] = "Z";
            }
            else if (biblioteca.Equals("Y"))
            {
                reader = new XmlTextReader(xmlYPath);
                articulo[3] = "Y";
            }
            else
            {
                reader = new XmlTextReader(xmlSPath);
                articulo[3] = "S";
            }

            int i = 0;
            while (reader.Read())
            {
                if (!(reader.Name.Equals("texto")) && !(reader.Name.Equals("book")) && !(reader.Name.Equals("libro")))
                switch (reader.NodeType)
                {
                    case XmlNodeType.Text:
                        articulo[i] = (reader.Value);
                        i++;
                        break;
                }
                if (i == 3){
                    if ((filtro.Equals("id")) || (filtro.Equals("identificador")) || (filtro.Equals("isbn")))
                    {
                        if (String.Equals(articulo[0], busqueda, StringComparison.CurrentCultureIgnoreCase)) break;
                    }
                    else if ((filtro.Equals("caratula")) || (filtro.Equals("nombre")) || (filtro.Equals("titulo")))
                    {
                        if (String.Equals(articulo[1], busqueda, StringComparison.CurrentCultureIgnoreCase)) break;
                    }
                    else if ((filtro.Equals("profesor")) || (filtro.Equals("escritor")) || (filtro.Equals("autor")))
                    {
                        if (String.Equals(articulo[2], busqueda, StringComparison.CurrentCultureIgnoreCase)) break;
                    }
                    i = 0;
                    articulo[0] = "NO EXISTE";
                    articulo[1] = "NO EXISTE";
                    articulo[2] = "NO EXISTE";
                    
                }
            }

            return articulo;
        }

        [WebMethod]
        public XmlDocument RespaldarCatalogo(String biblioteca)
        {
            XmlDocument respaldo = new XmlDocument();
            respaldo.PreserveWhitespace = true;
            try
            {
                if (biblioteca.Equals("Z"))
                {
                    respaldo.Load(xmlZPath);
                }
                else if (biblioteca.Equals("Y"))
                {
                    respaldo.Load(xmlYPath);                }
                else
                {
                    respaldo.Load(xmlSPath);
                }
                return respaldo;
                
            }
            catch (Exception e)
            {
                throw e;
            }
        }

    }
}
