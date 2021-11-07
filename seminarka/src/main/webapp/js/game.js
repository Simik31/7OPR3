import {
    css_vars,
    cells,
    player_x,
    player_o,
    test_rows_for_win,
    test_cols_for_win,
    test_dias_for_win,
    draw_win_lines
} from './core.js'

let on_move = player_o;

let steps = Array();

function display_on_move(text) {
    document.getElementById('on_move').innerHTML = text
}

function update_on_move() {
    on_move = (on_move === player_x) ? player_o : player_x;
    display_on_move('On move: <span style="color:' + css_vars[(on_move === player_x) ? 'color_x' : 'color_o'] + '">' + on_move + '</span>');
}

function uploadResult(result) {
    let id = document.getElementById("gameId").innerText;

    let ids = Cookies.get("resultIds");
    Cookies.set("resultIds", ids === undefined ? id : ids + "," + id);

    $.ajax({
        type: "POST",
        url: "./addResult",
        data: {
            id: id,
            result: result,
            steps: steps.toString()
        },
        error: function() { alertify.error("Server error"); }
    });
}

function win(win_rows, win_cols, win_dias) {
    cells.forEach(cell => cell.classList.remove('playable'));
    draw_win_lines(win_rows, win_cols, win_dias, on_move);
    uploadResult(on_move);
    display_on_move('Winner: <span style="color:' + css_vars[(on_move === player_x) ? 'color_x' : 'color_o'] + '">' + on_move + '</span>');
}

function draw() {
    cells.forEach(cell => cell.classList.remove('playable'));
    uploadResult("draw");
    display_on_move('Draw!');
}

function test_for_win() {
    let win_rows = test_rows_for_win();
    let win_cols = test_cols_for_win();
    let win_dias = test_dias_for_win();

    if (win_rows === false && win_cols === false && win_dias === false) {
        if (cells.some(cell => cell.innerText === ''))
            return 0;
        draw();
    } else
        win(win_rows, win_cols, win_dias);
}

function cell_click(cell) {
    if (!cell.classList.contains('playable'))
        return;

    steps.push(cell.id);

    cell.classList.remove('playable');
    cell.style['color'] = css_vars[(on_move === player_x) ? 'color_x' : 'color_o'];
    cell.innerText = on_move;

    if (test_for_win() === 0)
        update_on_move();
}

update_on_move();
cells.forEach(cell => cell.onclick = function() {cell_click(cell)});
