using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using Newtonsoft.Json;

namespace PLRDAL
{
    public static class JSONUtils
    {
        public class PLR_Response
        {
            public int PLRVersion { get; set; }
            public bool Success { get; set; }
            public string ErrorMsg { get; set; }
            public object Data { get; set; }
        }



        public static string ReturnError(string MensajeError)
        {
            return Newtonsoft.Json.JsonConvert.SerializeObject(
                new PLR_Response {
                    PLRVersion = 1,
                    Success = false,
                    ErrorMsg = MensajeError,
                    Data = null }
                , Formatting.Indented);
        }
    }
}