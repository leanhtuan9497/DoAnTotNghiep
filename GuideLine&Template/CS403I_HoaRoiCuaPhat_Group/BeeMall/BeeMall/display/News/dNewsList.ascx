<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="dNewsList.ascx.cs" Inherits="BeeMall.display.News.dNewsList" %>
<asp:Repeater ID="rptNewsDetail" runat="server">
    <HeaderTemplate>
        <table cellspacing="0" cellpadding="0" style="width: 100%;">
    </HeaderTemplate>
    <ItemTemplate>
        <tr>
            <td colspan="2"><a href='?f=news&fs=del&id=<%#:Eval("DelID") %>' class="title"><%#:Eval("Title") %></a></td>
        </tr>
        <tr>
            <td style="vertical-align: top;">
                <img src='/image/<%#:Eval("Image") %>' width="120px" style="padding: 5px 0px 5px 0px;" /></td>
            <td style="vertical-align: top;"><%#:Eval("Desc") %></td>
            <td></td>
        </tr>
    </ItemTemplate>
    <FooterTemplate>
        </table>
    </FooterTemplate>
</asp:Repeater>
