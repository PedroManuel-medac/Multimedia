<?php
include 'conexion.php';

// Obtención directa de variables POST (asumiendo que siempre llegan)
$nombre = $_POST['nombre'];
$edad = $_POST['edad'];

// Inserción directa sin escapar (¡INSEGURO!)
mysqli_query($conexion, "INSERT INTO usuarios(nombre, edad) VALUES ('$nombre', $edad)");

// Respuesta OK simple
echo json_encode(['resultado' => 'OK']);
?>