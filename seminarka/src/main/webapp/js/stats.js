function update(scope) {
    $.ajax({
        type: "POST",
        url: "./statsPercentage",
        data: {
            scope: scope,
        },
        error: function() { alertify.error("Server error"); }
    }).done(function(data) {set_values(scope, data)});
}

function set_values(scope, data) {
    let json = JSON.parse(data)[0];

    document.getElementById("percentage_x").innerText = json.px;
    document.getElementById("percentage_d").innerText = json.pd;
    document.getElementById("percentage_o").innerText = json.po;

    document.getElementById("bar_x").style.width = json.px;
    document.getElementById("bar_o").style.width = json.po;

    document.getElementById("count_x").innerText = "X wins: " + json.cx;
    document.getElementById("count_d").innerText = " Draws: " + json.cd;
    document.getElementById("count_o").innerText = "O wins: " + json.co;

    document.getElementById("scope_theoretical").style.textDecoration = "";
    document.getElementById("scope_global").style.textDecoration = "";
    document.getElementById("scope_local").style.textDecoration = "";

    document.getElementById("scope_" + scope).style.textDecoration = "underline";
}

update("theoretical");