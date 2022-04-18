using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;

namespace BeeMall.App_Code
{
    public class clsNews
    {
        public static DataTable GetList()
        {
            return DataAccess.selectQuery("select * from News_Categories");
        }

        public static DataTable GetListByCategoryID(int categoryID)
        {
            return DataAccess.selectQuery("select * from News_Categories where CateID="+categoryID);
        }

        public static void Insert(string CategoryName, int Order, bool Active)
        {
            DataAccess.ExecuteNoneQuery("insert into News_Categories values ('" + CategoryName + "'," + Order + "," +"'" +Active+"')");
        }

        public static void Update(int CateID,string CategoryName, int Order, bool Active)
        {
            DataAccess.ExecuteNoneQuery("update News_Categories set CategoryName='" + CategoryName + "'," +
                "[Order]=" + Order + "," + "Active='" + Active + "' where CateID="+CateID);
        }

        public static void Delete(int CateID)
        {
            DataAccess.ExecuteNoneQuery("delete from News_Categories where CateID="+CateID);
        }

        //Detail
        public static void InsertDetail(int CateID, string Title, string Desc, string Content, string Image, DateTime CreateDate, string Author, bool Active)
        {          
            DataAccess.ExecuteNoneQuery("Insert into News_Detail values (" + CateID + ",'" + Title + "','" + Desc + "','" +
                 Content + "','" + Image + "','" + CreateDate + "','" + Author + "','" + Active + "')");
        }

        public static DataTable GetListNewsDetail()
        {
             return DataAccess.selectQuery("select * from News_Detail");
        }

        public static DataTable GetNewsList()
        {
            return DataAccess.selectQuery("select * from News_Detail where Active='true' order by CreateDate desc");
        }

        public static DataTable GetNewsDetail(int DelID)
        {
            return DataAccess.selectQuery("select * from News_Detail where DelID="+DelID);
        }

        //public static DataTable GetNewsDetailOrther(int DelID)
        //{
        //    return DataAccess.selectQuery("select * from News_Detail where DelID=!" + DelID + " and Active='true'");
        //}
    }
}