<!DOCTYPE html>
<html>
<head>
    <base target="_top">
    <script>
        function LoadFile(event)
        {
            var file = event.target.files[0];
            var reader = new FileReader();
            reader.onload = function(e) {
                console.log(e.target.result);
                var fileData = e.target.result.substr(e.target.result.indexOf(",")+1);
                var mimeTypeStart = e.target.result.indexOf("data:") + 5;
                var mimeTypeEnd = e.target.result.indexOf(";");
                var mimeType = e.target.result.substr(mimeTypeStart, mimeTypeEnd - mimeTypeStart);
                var fileName = file.name;
                document.getElementById("fileData").value = fileData;
                document.getElementById("mimeType").value = mimeType;
                document.getElementById("fileName").value = fileName;
            };
            reader.readAsDataURL(file);
        }
    </script>
</head>
<body>
<h1>Web App File Loader</h1>
<?var url = getUrl();?>
<form method="post" action="<?= url ?>" >
    <table cellpadding="5px">
        <tr>
            <td>Username:</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>File:</td>
            <td><input type="file" name="file" onchange="LoadFile(event)" />
                <input type="hidden" id="fileData" name="fileData" />
                <input type="hidden" id="mimeType" name="mimeType" />
                <input type="hidden" id="fileName" name="fileName" /></td>
        </tr>
        <tr>
            <td colspan="2"><input type="submit" value="Load File" /></td>
        </tr>
        <tr>
            <td colspan="2"><span><?= message ?></span></td>
</form>
</body>
</html>