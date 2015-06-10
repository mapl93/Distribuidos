using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace WebServiceZ
{
    /// <summary>
    /// Summary description for WSBibliotecaZ
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WSBibliotecaZ : System.Web.Services.WebService
    {

        [WebMethod]
        public string HelloWorld()
        {
            return "Hello World";
        }

        [WebMethod]
        public String[] BuscaTitulo(String titulo)
        {
            String[] libro = new String[3];
            libro[0] = "ISBN";
            libro[1] = titulo;
            libro[2] = "Autor";
            //Llamado al middleware
            return libro;
        }

        [WebMethod]
        public String[] BuscaAutor(String autor)
        {
            String[] libro = new String[3];
            libro[0] = "ISBN";
            libro[1] = "Titulo";
            libro[2] = autor;
            //Llamado al middleware
            return libro;
        }

        [WebMethod]
        public String[] BuscaISBN(String isbn)
        {
            String[] libro = new String[3];
            libro[0] = isbn;
            libro[1] = "Titulo";
            libro[2] = "Autor";
            //Llamado al middleware
            return libro;
        }

        [WebMethod]
        public void ReplicaData()
        {

        }
    }
}
