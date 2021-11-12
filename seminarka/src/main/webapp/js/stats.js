function update(scope) {
    $.ajax({
        type: "POST",
        url: "./stats",
        data: {
            scope: scope,
        },
        error: function() { alertify.error("Server error"); }
    }).done(function(data) {set_values(scope, data)});
}

function set_values(scope, data) {
    let json = JSON.parse(data)[0];

    document.getElementById("percent_x").setAttribute("data-start", document.getElementById("percent_x").getAttribute("data-target"));
    document.getElementById("percent_x").setAttribute("data-target", json.px);

    document.getElementById("percent_d").setAttribute("data-start", document.getElementById("percent_d").getAttribute("data-target"));
    document.getElementById("percent_d").setAttribute("data-target", json.pd);

    document.getElementById("percent_o").setAttribute("data-start", document.getElementById("percent_o").getAttribute("data-target"));
    document.getElementById("percent_o").setAttribute("data-target", json.po);

    document.getElementById("bar_x").style.width = json.px + "%";
    document.getElementById("bar_o").style.width = json.po + "%";

    document.getElementById("counter_x").setAttribute("data-start", document.getElementById("counter_x").getAttribute("data-target"));
    document.getElementById("counter_x").setAttribute("data-target", json.cx);

    document.getElementById("counter_d").setAttribute("data-start", document.getElementById("counter_d").getAttribute("data-target"));
    document.getElementById("counter_d").setAttribute("data-target", json.cd);

    document.getElementById("counter_o").setAttribute("data-start", document.getElementById("counter_o").getAttribute("data-target"));
    document.getElementById("counter_o").setAttribute("data-target", json.co);

    document.getElementById("scope_theoretical").style.textDecoration = "";
    document.getElementById("scope_global").style.textDecoration = "";
    document.getElementById("scope_local").style.textDecoration = "";

    document.getElementById("scope_" + scope).style.textDecoration = "underline";

    document.querySelectorAll(".counter").forEach(counter => {
        const updateCount = () => {
            const start =  Number(counter.getAttribute('data-start'));
            const target = Number(counter.getAttribute('data-target'));
            const digits = Number(counter.getAttribute('data-digits'));
            const count =  Number(counter.innerText);

            if (start < target) {
                if (count < target) {
                    counter.innerText = (count + 1).toFixed(digits);
                    setTimeout(updateCount, 1000 / (target - start));
                } else {
                    counter.innerText = target;
                }
            } else {
                if (count > target) {
                    counter.innerText = (count - 1).toFixed(digits);
                    setTimeout(updateCount, 1000 / (start - target));
                } else {
                    counter.innerText = target;
                }
            }

        };

        updateCount();
    });
}

update("theoretical");