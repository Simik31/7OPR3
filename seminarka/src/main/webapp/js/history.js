function update(scope) {
    $.ajax({
        type: "POST",
        url: "./history",
        data: {
            scope: scope,
        },
        error: function() { alertify.error("Server error"); }
    }).done(function(data) {set_values(scope, data)});
}

function set_values(scope, data) {
    document.getElementById("results").innerHTML = data;

    document.getElementById("scope_global").style.textDecoration = "";
    document.getElementById("scope_local").style.textDecoration = "";

    document.getElementById("scope_" + scope).style.textDecoration = "underline";
}

update("global");