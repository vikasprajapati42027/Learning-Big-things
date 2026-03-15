const output = document.getElementById('framework-output');

document.querySelectorAll('button[data-action]').forEach((button) => {
  button.addEventListener('click', () => {
    const action = button.dataset.action;
    switch (action) {
      case 'react':
        output.textContent = 'React hook updated count in 124 ms, smooth animation ensured.';
        break;
      case 'redux':
        output.textContent = 'Redux store logged snapshot: { inventory: 27, user: { name: "Alex" } }.';
        break;
      case 'angular':
        output.textContent = 'Angular component rendered with change detection in Ivy mode.';
        break;
      default:
        output.textContent = 'Framework explanation ready.';
    }
  });
});
