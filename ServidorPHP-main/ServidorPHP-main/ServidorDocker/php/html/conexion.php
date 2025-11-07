<?php
$conexion = mysqli_connect("db","admin","admin1234","bd_android")
    or die("Error de conexión con la base de datos");
mysqli_set_charset($conexion, "utf8mb4");
?>