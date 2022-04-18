<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="dProductMenu.ascx.cs" Inherits="BeeMall.display.Product.dProductMenu" %>
<asp:Repeater ID="rptProductList" runat="server">
    <ItemTemplate>
        <li><a href="#"><%#:Eval("Name") %></a></li>
    </ItemTemplate>
</asp:Repeater>
