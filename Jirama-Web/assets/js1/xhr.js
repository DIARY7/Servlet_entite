const getXHR = () => {
    try {
        return new ActiveXObject('Msxml2.XMLHTTP');
    } catch (e) {
        try {   
            return new ActiveXObject('Microsoft.XMLHTTP');
        } catch (e2) {
            try {
                return new XMLHttpRequest();  
            } catch (e3) {
                return false;
            }
        }
    }
};

const sendXHRRequest = (url, method = 'GET', formData = null) => {
    return new Promise((resolve, reject) => {
        let xhr = getXHR();

        xhr.addEventListener('load', event => {
            resolve(event.target.responseText);
        });

        xhr.addEventListener('error', event => {
            reject(event.target.responseText);
        });

        xhr.open(method, url);

        xhr.send(formData);
    });
};