document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('#decryptForm');
    const resultDiv = document.querySelector('#resultDiv');
    const decryptedTextElement = document.querySelector('#decryptedText');
    const encryptedTextInput = document.querySelector('#encryptedText');

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const encryptedText = encryptedTextInput.value;

        fetch('/decrypt', {
            method: 'POST',
            headers: {
                'Content-Type': 'text/plain'
            },
            body: encryptedText
        })
            .then(response => response.text())
            .then(decryptedText => {
                decryptedTextElement.textContent = decryptedText;
                resultDiv.style.display = 'block';
            })
            .catch(error => {
                console.error('Ошибка:', error);
            });
    });

    // Добавляем обработчик события keypress для поля ввода
    encryptedTextInput.addEventListener('keypress', function(event) {
        if (event.key === 'Enter') {
            event.preventDefault();
            form.dispatchEvent(new Event('submit'));
        }
    });
});