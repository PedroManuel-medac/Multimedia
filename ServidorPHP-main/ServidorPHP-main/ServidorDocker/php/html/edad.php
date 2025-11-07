<?php
include 'conexion.php';

//Recibimos el nombre buscado por parametro GET
$nombre_buscado = $_GET['nombre'];

//Consultar buscando coincidencias exactas por nombre
$res = mysqli_query($conexion, "SELECT * FROM usuarios WHERE nombre = '$nombre_buscar'");

//Obtener el primer resultado que coincida 
$usuario = mysqli_fetch_assoc($res);

//Devolvemos el usuario encontrado (o null si no existe ninguno)
echo json_encode($usuario);
?>
