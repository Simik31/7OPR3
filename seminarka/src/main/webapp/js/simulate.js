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

function update_on_move() {
    on_move = (on_move === player_x) ? player_o : player_x;
}

function test_for_win() {
    let win_rows = test_rows_for_win();
    let win_cols = test_cols_for_win();
    let win_dias = test_dias_for_win();

    if (win_rows === false && win_cols === false && win_dias === false) {
        if (cells.some(cell => cell.innerText === ''))
            return 0;
    } else
        draw_win_lines(win_rows, win_cols, win_dias, on_move);
}

function cell_click(cell_id) {
    const cell = document.getElementById(cell_id);

    cell.style['color'] = css_vars[(on_move === player_x) ? 'color_x' : 'color_o'];
    cell.innerText = on_move;

    if (test_for_win() === 0)
        update_on_move();
}

update_on_move();
Array.from(document.getElementById("steps").value.split(",")).forEach(step => cell_click(step))
