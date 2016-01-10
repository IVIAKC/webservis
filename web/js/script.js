/**
 * Created by IVIAKC on 06.11.2015.
 */
var text_doc;
var j=1;
var writ;
function tab_load(){
    var ajax = new XMLHttpRequest();
    ajax.open('GET','http://smart-route.ru:8100/adapter-web/rest/dictionary/c580d006-f86f-4bdd-84be-b51de6f626c6',false);
    ajax.send();

    var response = ajax.responseText;
    text = JSON.parse(response);
    writ = text.documents;
    text_doc=writ;
    add();
}

function compareAge(personA, personB) {
    return personA.fio > personB.fio;
}

function Search(){

    var v = document.getElementById('search').value;
    console.log("Index: " + v);
    writ = text_doc.filter(function(number){
        console.log("Index: " + number.fio);
        console.log("Index: " + number.fio.indexOf(v));
        if(number.fio.indexOf(v)>=0) return true;
        else return false;});
    writ.sort(compareAge);
    del();
    add();

}

function add(){
    console.log("Add work");
    var tab = document.getElementById('table_in');
    j=1;
    writ.forEach(function(item){
        var tr = document.createElement('tr');
        tr.id='bod';
        tab.appendChild(tr);
        for(var i=0;i<5;i++){
            var td = document.createElement('td');
            switch (i) {
                case 0:
                    td.innerHTML = j;
                    break;
                case 1:
                    td.innerHTML = item.fio;
                    break;
                case 2:
                    td.innerHTML = item.gender;
                    break;
                case 3:
                    td.innerHTML = item.birthDate;
                    break;
                case 4:
                    td.innerHTML = item.phone;
                    break;
            }
            tr.appendChild(td);
        }
        j++;
    });

}
function del() {
    for (var i = 1; i < j; i++) {
        var el = document.getElementById('bod');
        el.parentNode.removeChild(el);
    }

}
function send_sub(){
    var ajax = new XMLHttpRequest();
    var log = document.getElementById("inp_log").value;
    var pas = document.getElementById("inp_pass").value;
    ajax.open('POST', '/web-start/login', false);

    var json = new Object();
    json.login = log;
    json.password = pas;
    ajax.send(JSON.stringify(json));
    var otv =  ajax.responseText;
    alert(otv);
}