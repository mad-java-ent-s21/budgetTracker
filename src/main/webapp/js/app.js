const {google} = require('googleapis');
const path = require('path');
const fs = require('fs');

const CLIENT_ID = '797480132712-kh0sfs9uaukcrsqnnshvcnkoa4ms89jq.apps.googleusercontent.com';
const CLIENT_SECRET = 'QjZITi2PM_s7wZOKFqFXplDQ';
const REDIRECT_URI = 'https://developers.google.com/oauthplayground';

const REFRESH_TOKEN = '1//04zRU0ZYXTCGwCgYIARAAGAQSNwF-L9IrYBjJ8J6cXbH9yx6wjvl_jR6oQG012u-8r2yAOtwDkRkbRA72VgKMxmhtlApoNFQ1-mE';

const oauth2Client = new google.auth.OAuth2(
    CLIENT_ID,
    CLIENT_SECRET,
    REDIRECT_URI
);

oauth2Client.setCredentials({refresh_token: REFRESH_TOKEN});

const drive = google.drive({
    version: 'v3',
    auth: oauth2Client
});

const filePath = path.join(__dirname, 'filename.csv');

async function uploadFile() {
    try {
        const response = await drive.files.create({
            requestBody: {
                name: 'filename.csv',
                mimeType: 'text/csv'
            },
            media: {
                mimeType: '',
                body: fs.createReadStream(filePath)
            }
        })

        console.log(response.data)

    } catch (error) {
        console.log(error.message)
    }
}

uploadFile();

async function deleteFile() {
    try {
        const response = await drive.files.delete({
            fileId: 'fileId',
        });
        console.log(response.data, response.status);

    } catch (error) {
        console.log(error.message);
    }
}