<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Información de Contacto</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-8">
            <h2 class="text-center mt-5">Información de Contacto Recibida</h2>
            <div class="card mt-3">
                <div class="card-header">
                    <h4>Contacto</h4>
                </div>
                <div class="card-body">
                    <p><strong>Nombre:</strong> ${nombre}</p>
                    <p><strong>Correo Electrónico:</strong> ${email}</p>
                    <p><strong>Mensaje:</strong> ${mensaje}</p>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="row justify-content-center">
    <a href="/contacto"><button type="button" class="btn btn-primary btn-block">Volver al formulario de contacto</button></a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
