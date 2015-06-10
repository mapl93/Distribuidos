<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="BibliotecaZ.aspx.cs" Inherits="BibliotecaZ.BibliotecaZ" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <title>Biblioteca Z</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">

    <!-- Latest compiled and minified JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body style="background-color:#5E4586">
    <form id="form1" runat="server">
        <div>
            <div class="col-sm-7 col-md-7 col-lg-7 col-md-offset-1">
                <asp:TextBox id="tbBusqueda" runat="server" placeholder="Buscar..." class="form-control" style="display: inline"></asp:TextBox>
            </div>
            <div class="col-sm-2 col-md-2 col-lg-2">    
                <asp:DropDownList id="comboFiltro"  class="btn btn-default dropdown-toggle" runat="server" style="display: inline">
                </asp:DropDownList>
            </div>
            <div class="col-sm-1 col-md-1 col-lg-1">
                <button runat="Server" type="submit" class="btn btn-primary" onserverclick="BuscarProyectos">Buscar</button>   
            </div>
        </div>
    </form>
</body>
</html>
