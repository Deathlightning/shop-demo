function notify(type, message) {
    const div = document.createElement('div');
    div.id = 'div-eg';
    div.hidden = true;
    div.classList.add('notify-position');
    div.innerHTML = ` <div style="display: flex;justify-content: center;" id="notify">
        <div class="notify-${type}">
            <div style="font-weight: bold">&nbsp;&nbsp;</div>
            <div style="font-size: 18px;word-wrap: break-word;word-break: break-all;overflow: hidden;text-align: left">
                ${message}
            </div>
        </div>
    </div>`;
    const elem = document.getElementsByTagName('body')[0].appendChild(div);
    animation();//执行动画
    window.setTimeout(function () {
        elem.parentElement.removeChild(elem);
    }, 1000);
}

function animation() {
    const dom = document.getElementById('notify');
    dom.parentElement.hidden = false;
    dom.parentElement.classList.add('notify');
    window.setTimeout(function () {
        dom.parentElement.hidden = true;
        dom.parentElement.classList.remove('notify');
    }, 1000);
}
