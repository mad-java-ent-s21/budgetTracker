function doGet(e) {
  var htmlOutput =  HtmlService.createTemplateFromFile('UploadFile');
  htmlOutput.message = '';
  return htmlOutput.evaluate();
}


function doPost(e) {

  Logger.log(JSON.stringify(e));

  var destination_id = '15wwz067V2oQjA1gGArJUoWvr9sxPzSP0';  // ID OF GOOGLE DRIVE DIRECTORY;
  var destination = DriveApp.getFolderById(destination_id);

  var data = Utilities.base64Decode(e.parameter.fileData);
  var blob = Utilities.newBlob(data, e.parameter.mimeType, e.parameter.fileName);
  destination.createFile(blob);

  listRecord(e.parameter.username, e.parameter.fileName);

  var htmlOutput =  HtmlService.createTemplateFromFile('UploadFile');
  htmlOutput.message = 'File Uploaded';
  return htmlOutput.evaluate();

}

function listRecord(username, filename)
{
  var url = 'https://docs.google.com/spreadsheets/d/1z-Yl1W-rHrIHNshTstUc7sDmNXk9fAgnGJB8nFyXyJQ/edit#gid=0';  //URL OF GOOGLE SHEET;
  var ss= SpreadsheetApp.openByUrl(url);
  var recordsSheet = ss.getSheetByName("Records");
  recordsSheet.appendRow([username, filename, new Date()]);
}

function getUrl() {
 var url = ScriptApp.getService().getUrl();
 return url;
}