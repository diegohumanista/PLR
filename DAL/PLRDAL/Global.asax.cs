using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;
using System.Web.SessionState;

namespace PLRDAL
{
    public class Global : System.Web.HttpApplication
    {

        protected void Application_Start(object sender, EventArgs e)
        {

        }

        protected void Session_Start(object sender, EventArgs e)
        {

        }

        protected void Application_BeginRequest(object sender, EventArgs e)
        {
            string[] Comandos = Request.Url.AbsolutePath.Split('/');

            if (Comandos[1].ToString().ToLower() == "login")
            {
                Response.ContentType = "application/json";
                Response.Write(Login.Process(Request));
            } else { 
                Response.Write("<HTML><BODY>Hola<BR>");
                for (int i = 0; i < Comandos.Length; i++) Response.Write(i.ToString() + "='" + Comandos[i] + "'<BR>");
                Response.Write("</BODY></HTML>");
            }

            Response.End();
        }

        protected void Application_AuthenticateRequest(object sender, EventArgs e)
        {

        }

        protected void Application_Error(object sender, EventArgs e)
        {

        }

        protected void Session_End(object sender, EventArgs e)
        {

        }

        protected void Application_End(object sender, EventArgs e)
        {

        }
    }
}