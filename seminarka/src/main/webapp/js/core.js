export const css_vars = {
    "cell_center": Number(getComputedStyle(document.documentElement).getPropertyValue('--cell-size').replace("px", "").replace(' ', '')) / 2,
    "space_size": Number(getComputedStyle(document.documentElement).getPropertyValue('--space-size').replace("px", "").replace(' ', '')),
    "space_void": Number(getComputedStyle(document.documentElement).getPropertyValue('--space-void').replace("px", "").replace(' ', '')),
    "color_x": getComputedStyle(document.documentElement).getPropertyValue('--player-x-color').replace(' ', ''),
    "color_o": getComputedStyle(document.documentElement).getPropertyValue('--player-o-color').replace(' ', ''),
}

if (css_vars.cell_center === 0)
    window.location.reload();

export const cells = Array.from(document.getElementsByClassName('cell'));

export const player_x = 'x';
export const player_o = 'O';

export function test_rows_for_win() {
    for (let r = 0; r < 3; r++) {
        let cell1 = cells[r * 3].innerText;
        let cell2 = cells[r * 3 + 1].innerText;
        let cell3 = cells[r * 3 + 2].innerText;

        if (cell1 !== '' && cell2 !== '' && cell3 !== '' && cell1 === cell2 && cell2 === cell3)
            return r;
    }

    return false;
}

export function test_cols_for_win() {
    for (let c = 0; c < 3; c++) {
        let cell1 = cells[c].innerText;
        let cell2 = cells[c + 3].innerText;
        let cell3 = cells[c + 6].innerText;

        if (cell1 !== '' && cell2 !== '' && cell3 !== '' && cell1 === cell2 && cell2 === cell3)
            return c;
    }
    return false;
}

export function test_dias_for_win() {
    let cell0 = cells[0].innerText;
    let cell2 = cells[2].innerText;
    let cell4 = cells[4].innerText;
    let cell6 = cells[6].innerText;
    let cell8 = cells[8].innerText;

    if (cell0 !== '' && cell4 !== '' && cell8 !== '' && cell0 === cell4 && cell4 === cell8)
        return 1;

    if (cell2 !== '' && cell4 !== '' && cell6 !== '' && cell2 === cell4 && cell4 === cell6)
        return -1;

    return false;
}

export function draw_win_lines(win_rows, win_cols, win_dias, winner) {
    let top;
    let deg;

    if (win_rows !== false) {
        top = win_rows - 1;
        deg = 0;
    }
    if (win_cols !== false) {
        top = win_cols - 1;
        deg = -90;
    }
    if (win_dias !== false) {
        top = 0;
        deg = win_dias * 45;
    }

    let lineOuter = document.createElement("span");
    lineOuter.id = "wo";
    lineOuter.classList.add((win_dias === false) ? "vh" : "d");
    lineOuter.classList.add("spacer");
    lineOuter.classList.add("position-fixed");
    lineOuter.classList.add("outer");
    lineOuter.style.transform = "rotate(" + deg + "deg) translateY(calc(" + top + " * (var(--cell-size) + var(--space-size) + 2 * var(--space-void))))";
    document.getElementsByClassName("content")[0].appendChild(lineOuter);

    let lineInner = document.createElement("span");
    lineInner.id = "wi";
    lineInner.classList.add((win_dias === false) ? "vh" : "d");
    lineInner.classList.add("spacer");
    lineInner.classList.add("position-fixed");
    lineInner.style.borderColor = (winner === player_x) ? css_vars.color_x : css_vars.color_o;
    lineInner.style.transform = "rotate(" + deg + "deg) translateY(calc(" + top + " * (var(--cell-size) + var(--space-size) + 2 * var(--space-void))))";
    document.getElementsByClassName("content")[0].appendChild(lineInner);
}
