const domButton = document.getElementById('dom-button');
const domOutput = document.getElementById('dom-output');
const promiseButton = document.getElementById('promise-button');
const promiseStatus = document.querySelector('#promise-status span');

domButton.addEventListener('click', () => {
  const span = document.createElement('span');
  span.textContent = `New node at ${new Date().toLocaleTimeString()}`;
  span.className = 'badge';
  domOutput.prepend(span);
});

promiseButton.addEventListener('click', () => {
  promiseStatus.textContent = 'pending';
  simulateFetch()
    .then((message) => {
      promiseStatus.textContent = 'fulfilled';
      domOutput.textContent = message;
    })
    .catch(() => {
      promiseStatus.textContent = 'rejected';
    });
});

function simulateFetch() {
  return new Promise((resolve) => {
    setTimeout(() => {
      resolve('Promise resolved with server data.');
    }, 900);
  });
}
