using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PLRDAL
{
    public class Login
    {
        public static string Process(HttpRequest Request)
        {
            return JSONUtils.ReturnError("Funcion no definida");
        }

        public static string DoLogin(HttpRequest Request)
        {
            return "{Success: false, ErrorMsg: \"Parámetros incorrectos\"}";
        }
    }
}