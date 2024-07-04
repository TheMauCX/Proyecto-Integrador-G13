$(document).ready(function(){
    listar();
});
function listar() {
    $.get('estudiante',{'opc':1}, function (data) {
        let x = JSON.parse(data);
        $(".table tbody tr").remove();
        for (var i = 0; i < x.length; i++) {
            $(".table").append("<tr><td>"+(i+1)+"</td><td>"+x[i].idestudiante+"</td><td>"+x[i].nombres+"</td><td>"+x[i].apellidos+"</td><td>"+x[i].correo+"</td><td>"+x[i].telefono+"</td><td>"+x[i].idcarrera+"</td><td>"+x[i].estado+"</td><td><a href='#' onclick='editar("+x[i].idcarrera+")'><i class='far fa-edit'>a</i></a></td><td><a href='#' onclick='eliminar("+x[i].idcarrera+")'><i class='fas fa-trash-alt'>e</i></a></td></tr>");
        }
    });
}
$("#guardar").click(function (){
    let estudiante = $("#estudiante").val();
    let apellidos = $("#apellidos").val();
    let correo = $("#correo").val();
    let telefono = $("#telefono").val();
    let idcarrera = $("#idcarrera").val();
    $.post("estudiante",{'opc':2, 'nombres':estudiante, 'apellidos':apellidos, 'correo':correo, 'telefono':telefono, 'idcarrera':idcarrera}, function (data) {
        listar();
    });
    $("#exampleModal").modal('hide');
});
function eliminar(id){
    $.get('estudiante',{'opc':3,'id':id}, function (data) {
        listar();
    });
}
$('#editar').click(function (){
    let estudiante = $('#estudiante_edit').val();
    let id = $('#id_estudiante_edit').val();
    let apellidos = $("#apellidos_edit").val();
    let correo = $("#correo_edit").val();
    let telefono = $("#telefono_edit").val();
    let idcarrera = $("#idcarrera_edit").val();
    $.get('estudiante',{'opc':5,'id':id, 'nombres':estudiante, 'apellidos':apellidos, 'correo':correo, 'telefono':telefono, 'idcarrera':idcarrera},function (data) {
        listar();
    });
    $('#exampleModal2').modal('hide');
});
function editar(id){
    let nom_estudiante = $('#estudiante_edit').val();
    let apellidos = $("#apellidos_edit").val();
    let correo = $("#correo_edit").val();
    let telefono = $("#telefono_edit").val();
    let idcarrera = $("#idcarrera_edit").val();
    $.get('estudiante',{'opc':4,'id':id, 'nombres':nom_estudiante, 'apellidos':apellidos, 'correo':correo, 'telefono':telefono, 'idcarrera':idcarrera}, function (data) {
        let x = JSON.parse(data);
        $('#estudiante_edit').val(x.nombres);
        $('#id_estudiante_edit').val(x.idestudiante);
        $('#exampleModal2').modal('show');
    });
}





