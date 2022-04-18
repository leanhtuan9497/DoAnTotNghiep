using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace BeeMall
{
    public class DataAccess
    {
        static string ConnectionString = @"Data Source=(LocalDB)\MSSQLLocalDB;AttachDbFilename=D:\Study\cong nghe phan mem\CS403I_HoaRoiCuaPhat_Group\BeeMall\BeeMall\App_Data\Database1.mdf;Integrated Security=True";
        public static DataTable selectQuery(string query)
        {
            DataTable dt = new DataTable();
            SqlConnection cnn = new SqlConnection(ConnectionString);
            cnn.Open();
            SqlCommand cmd = new SqlCommand(query, cnn);
            dt.Load(cmd.ExecuteReader());
            cnn.Close();
            return dt;
        }


        public static void ExecuteNoneQuery(string query)
        {
            SqlConnection cnn = new SqlConnection(ConnectionString);
            cnn.Open();
            SqlCommand cmd = new SqlCommand(query, cnn);
            cmd.ExecuteNonQuery();
            cnn.Close();
        }
    }
}