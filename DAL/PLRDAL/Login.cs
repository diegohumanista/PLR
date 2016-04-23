using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace PLRDAL
{
    public class Login
    {
        public class LoginData
        {
            public int UserID { get; set; }
        }

        public static string Process(HttpRequest Request)
        {
            if (Request.Params["user"] == null)
            {
                return JSONUtils.ReturnError("No se ingreso un usuario");
            };
            if (Request.Params["user"].ToString() != "pepe") {
                return JSONUtils.ReturnError("Usuario invalido");
            };
            if (Request.Params["password"] == null)
            {
                return JSONUtils.ReturnError("No se ingreso un password");
            };
            if (Request.Params["password"].ToString() != "lepew") {
                return JSONUtils.ReturnError("Password invalido");
            };
            return JSONUtils.ReturnSuccess(new LoginData { UserID = 1});
        }

        public static string DoLogin(HttpRequest Request)
        {
            return "{Success: false, ErrorMsg: \"Parámetros incorrectos\"}";
        }
    }
}