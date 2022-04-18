<%@ Control Language="C#" AutoEventWireup="true" CodeBehind="AdminControl.ascx.cs" Inherits="BeeMall.admin.AdminControl" %>
<%@ Register Src="~/admin/Menu.ascx" TagPrefix="uc1" TagName="Menu" %>

<div>Banner admin</div>
<table cellspacing="0" cellpadding="0" style="width:100%;">
    <tr>
        <td style="width:200px;">
            <uc1:Menu runat="server" id="Menu" />
        </td>
        <td style="width:10px;">&nbsp</td>
        <td>
            <asp:PlaceHolder ID="plLoad" runat="server"></asp:PlaceHolder>
        </td>
    </tr>
</table>