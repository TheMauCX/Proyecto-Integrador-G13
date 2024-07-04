$(document).ready(function(){
    listar();
});

function listar() {
    $.get('acceso', {'opc': 1}, function(data) {
        let x = JSON.parse(data);
        $(".table tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            $(".table").append("<tr><td>" + (i+1) + "</td><td>" + x[i].idacceso + "</td><td>" + x[i].nombre + "</td><td>" + x[i].estado + "</td><td><a href='#' onclick='editar(" + x[i].idacceso + ")'><i class='far fa-edit'>EDITAR</i></a></td><td><a href='#' onclick='eliminar(" + x[i].idacceso + ")'><i class='fas fa-trash-alt'>ELIMINAR</i></a></td></tr>");
        }
    });
}

$("#guardar").click(function() {
    let acceso = $("#acceso").val();
    $.post("acceso", {'opc': 2, 'acceso': acceso}, function(data) {
        listar();
    });
    $("#exampleModal").modal('hide');
});

function eliminar(id) {
    $.get('acceso', {'opc': 3, 'id': id}, function(data) {
        listar();
    });
}

$('#editar').click(function() {
    let acceso = $('#acceso_edit').val();
    let id = $('#id_acceso_edit').val();
    let estado = $('#estado_edit').val();
    $.get('acceso', {'opc': 5, 'id': id, 'acceso': acceso, 'estado':estado}, function(data) {
        listar();
    });
    $('#exampleModal2').modal('hide');
});

function editar(id) {
    $.get('acceso', {'opc': 4, 'id': id}, function(data) {
        console.log("Datos recibidos para edición: ", data);
        let x = JSON.parse(data);
        $('#acceso_edit').val(x.nombre);
        $('#estado_edit').val(x.estado);
        $('#id_acceso_edit').val(x.idacceso);  // Corrige esto si el campo id en la respuesta es 'idrol'
        $('#exampleModal2').modal('show');
    });
}
