<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Factura</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        table {
            border-collapse: collapse;
            width: 100%;
            margin-bottom: 20px;
        }

        table,
        th,
        td {
            border: 1px solid black;
            padding: 5px;
            text-align: center;
        }

        th {
            background-color: #f2f2f2;
        }

        thead {
            background-color: #ccc;
        }

        tfoot {
            background-color: #f2f2f2;
        }

        tfoot td {
            font-weight: bold;
        }
    </style>
</head>

<body>

    <table class="table table-stryped">
        <thead class="thead-dark">
            <tr>
                <th>#</th>
                <th>Descripción</th>
                <th>Precio</th>
                <th>Existencias</th>
                <th>Total</th>
                <th></th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <% List<Item> items = (List<Item>) session.getAttribute("items");
                    int contador = 0;
                    double totalCompra = 0.0;
                    for (Item item : items) {
                    contador++;
                    %>
                    <tr>
                        <td>
                            <%= contador %>
                        </td>
                        <td>
                            <%= item.getDescripcion() %>
                        </td>
                        <td class="text-end">
                            <%= item.getPrecio() %>
                        </td>
                        <td class="text-center">
                            <%= item.getCantidad() %>
                        </td>
                        <td class="text-center">
                            <%= item.getCantidad()*item.getPrecio() %>
                        </td>
                        <td>
                            <a href="/carrito/eliminar/<%= item.getIdArticulo() %>" class="btn btn-danger">
                                <i class='fas fa-trash'></i> Eliminar
                            </a>
                        </td>
                        <td>
                            <a href="/carrito/modificar/<%= item.getIdArticulo() %>" class="btn btn-success">
                                <i class='fas fa-pencil'></i> Modificar
                            </a>
                        </td>
                    </tr>
                    <% totalCompra +=item.getCantidad()*item.getPrecio(); } %>
        </tbody>
        <tfoot>
            <tr>
                <th colspan="4" class="text-end">Total:</th>
                <td class="text-center">
                    <%= totalCompra %>
                </td>
                <td></td>
                <td></td>
            </tr>
        </tfoot>
    </table>



</body>

</html>