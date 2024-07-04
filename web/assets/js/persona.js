$(document).ready(function(){
    listar();
});

function listar() {
    $.get('persona', {'opc': 1}, function(data) {
        let x = JSON.parse(data);
        $(".table tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            $(".table").append("<tr><td>" + (i+1) + "</td><td>" + x[i].idpersona + "</td><td>" + x[i].nombre + "</td><td>" + x[i].apepat + "</td><td>"+ x[i].apemat + "</td><td>"+ x[i].numero + "</td><td>"+ x[i].correo + "</td><td>"+ x[i].fecha + "</td><td>"+ x[i].estado + "</td><td><a href='#' onclick='editar(" + x[i].idpersona + ")'><i class='far fa-edit'>a</i></a></td><td><a href='#' onclick='eliminar(" + x[i].idpersona + ")'><i class='fas fa-trash-alt'>e</i></a></td></tr>");
        }
    });
}

$("#guardar").click(function() {
    let nombre = $("#nombre").val();
    let apepat = $("#apepat").val();
    let apemat = $("#apemat").val();
    let numero = $("#numero").val();
    let correo = $("#correo").val();
    let fechas = $("#fecha").val();
    $.post("persona", {'opc': 2, 'nombre': nombre, 'apepat': apepat, 'apemat': apemat, 'numero': numero, 'correo': correo, 'fecha': fechas}, function(data) {
        listar();
    });
    $("#exampleModal").modal('hide');
});

function eliminar(id) {
    $.get('persona', {'opc': 3, 'id': id}, function(data) {
        listar();
    });
}

$('#editar').click(function() {
    let nombre = $('#nombre_edit').val();
    let apepat = $('#apepat_edit').val();
    let apemat = $('#apemat_edit').val();
    let numero = $('#numero_edit').val();
    let correo = $('#correo_edit').val();
    let fechas = $('#fecha_edit').val();
    let id = $('#id_persona_edit').val();
    let estado = $('#estado_edit').val();
    $.get('persona', {'opc': 5, 'id': id, 'nombre': nombre, 'apepat': apepat, 'apemat': apemat, 'numero': numero, 'correo': correo, 'fecha': fechas, 'estado':estado}, function(data) {
        listar();
    });
    $('#exampleModal2').modal('hide');
});

function editar(id) {
    $.get('persona', {'opc': 4, 'id': id}, function(data) {
        console.log("Datos recibidos para edición: ", data);
        let x = JSON.parse(data);
        $('#nombre_edit').val(x.nombre);
        $('#apepat_edit').val(x.apepat);
        $('#apemat_edit').val(x.apemat);
        $('#numero_edit').val(x.numero);
        $('#correo_edit').val(x.correo);
        $('#fecha_edit').val(x.fechas);
        $('#id_persona_edit').val(x.idpersona);  // Corrige esto si el campo id en la respuesta es 'idrol'
        $('#exampleModal2').modal('show');
    });
}
