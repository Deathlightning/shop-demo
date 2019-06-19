let attributes = [{
    key: '商品名称',
    value: ''
}, {
    key: '商品类别',
    value: ''
}, {
    key: '商品库存',
    value: ''
}, {
    key: '商品价格',
    value: ''
}];

function addRow() {
    const tb = document.getElementById('table');
    const rowCount = tb.rows.length;
    let row = tb.insertRow(rowCount);
    let cell0 = row.insertCell(0);
    let cell1 = row.insertCell(1);
    let cell2 = row.insertCell(2);
    cell0.contentEditable = 'true';
    cell0.innerHTML = '属性名';
    cell1.contentEditable = 'true';
    cell1.innerHTML = '属性值';
    cell2.innerHTML = '<button class="btn btn-danger" onclick="deleteRow(' + (rowCount) + ')">删除</button>';
}

function deleteRow(id) {
    const tb = document.getElementById('table');
    tb.deleteRow(id);
    for (let i = 1; i < tb.rows.length; i++) {
        const buttonCell = tb.rows[i].cells[2];
        if (i > 3) {
            buttonCell.innerHTML = '<button class="btn btn-danger" onclick="deleteRow(' + (i) + ')">删除</button>';
        } else {
            buttonCell.innerHTML = '';
        }
        console.log('执行');
    }
}

function submit() {
    attributes = [];
    const tb = document.getElementById('table');
    for (let i = 1; i < tb.rows.length; i++) {
        attributes.add({
            key: tb.rows[i][0],
            value: tb.rows[i][1],
        })
    }
}

function tableInit() {
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/shopdemo_war_exploded/goodInfoController',
        contentType: "application/json; charset=utf-8",
        data: {goodId: 1},
        dataType: "json",
        success: function (response) {
            console.log(response)
        },
        error: function (message) {
            console.error(message);
            renderTable(attributes);
        }
    })
}

//本函数会根据attributes数组对表格重新初始化
function renderTable(attributes) {
    const table = document.getElementById('table');
    let rowCount = table.rows.length;
    for (let i = 1; i < rowCount; i++) {
        table.deleteRow(1);
    }
    for (let i = 0; i < attributes.length; i++) {
        const row = table.insertRow(i + 1);
        const cell0 = row.insertCell(0);
        const cell1 = row.insertCell(1);
        const cell2 = row.insertCell(2);

        cell0.innerHTML = attributes[i].key;
        cell1.innerHTML = attributes[i].value;
        cell1.contentEditable = 'true';
        if (i > attributes.length - 1) {
            cell0.contentEditable = 'true';
            cell2.innerHTML = '<button class="btn btn-danger" onclick="deleteRow(' + (i + 1) + ')">删除</button>';
        }

    }
}
