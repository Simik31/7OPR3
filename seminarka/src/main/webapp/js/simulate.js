const player_x = 'x';
const player_o = 'O';

let on_move = player_o;

const elements = {
    "cells": Array.from(document.getElementsByClassName('cell'))
};

const css_vars = {
    "cell_center": Number(getComputedStyle(document.documentElement).getPropertyValue('--cell-size').replace("px", "").replace(' ', '')) / 2,
    "space_size": Number(getComputedStyle(document.documentElement).getPropertyValue('--space-size').replace("px", "").replace(' ', '')),
    "space_void": Number(getComputedStyle(document.documentElement).getPropertyValue('--space-void').replace("px", "").replace(' ', '')),
    "color_x": getComputedStyle(document.documentElement).getPropertyValue('--player-x-color').replace(' ', ''),
    "color_o": getComputedStyle(document.documentElement).getPropertyValue('--player-o-color').replace(' ', ''),
}

function update_on_move() {
    on_move = (on_move === player_x) ? player_o : player_x;
}

function test_rows_for_win() {
    for (let r = 0; r < 3; r++) {
        let cell1 = elements.cells[r * 3].innerText;
        let cell2 = elements.cells[r * 3 + 1].innerText;
        let cell3 = elements.cells[r * 3 + 2].innerText;

        if (cell1 !== '' && cell2 !== '' && cell3 !== '' && cell1 === cell2 && cell2 === cell3)
            return r;
    }

    return false;
}

function test_cols_for_win() {
    for (let c = 0; c < 3; c++) {
        let cell1 = elements.cells[c].innerText;
        let cell2 = elements.cells[c + 3].innerText;
        let cell3 = elements.cells[c + 6].innerText;

        if (cell1 !== '' && cell2 !== '' && cell3 !== '' && cell1 === cell2 && cell2 === cell3)
            return c;
    }
    return false;
}

function test_dias_for_win() {
    let cell0 = elements.cells[0].innerText;
    let cell2 = elements.cells[2].innerText;
    let cell4 = elements.cells[4].innerText;
    let cell6 = elements.cells[6].innerText;
    let cell8 = elements.cells[8].innerText;

    if (cell0 !== '' && cell4 !== '' && cell8 !== '' && cell0 === cell4 && cell4 === cell8)
        return 1;

    if (cell2 !== '' && cell4 !== '' && cell6 !== '' && cell2 === cell4 && cell4 === cell6)
        return -1;

    return false;
}

function win(win_rows, win_cols, win_dias) {
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
    lineOuter.classList.add("outer");
    lineOuter.style.transform = "rotate(" + deg + "deg) translateY(calc(" + top + " * (var(--cell-size) + var(--space-size) + 2 * var(--space-void))))";
    document.getElementsByClassName("content")[0].appendChild(lineOuter);

    let lineInner = document.createElement("span");
    lineInner.id = "wi";
    lineInner.classList.add((win_dias === false) ? "vh" : "d");
    lineInner.classList.add("spacer");
    lineInner.style.borderColor = (on_move === player_x) ? css_vars.color_x : css_vars.color_o;
    lineInner.style.transform = "rotate(" + deg + "deg) translateY(calc(" + top + " * (var(--cell-size) + var(--space-size) + 2 * var(--space-void))))";
    document.getElementsByClassName("content")[0].appendChild(lineInner);
}

function test_for_win() {
    let win_rows = test_rows_for_win();
    let win_cols = test_cols_for_win();
    let win_dias = test_dias_for_win();

    if (win_rows === false && win_cols === false && win_dias === false) {
        if (elements.cells.some(cell => cell.innerText === ''))
            return 0;
    } else
        win(win_rows, win_cols, win_dias);
}

function cell_click(cell_id) {
    const cell = document.getElementById(cell_id);

    cell.style['color'] = css_vars[(on_move === player_x) ? 'color_x' : 'color_o'];
    cell.innerText = on_move;

    if (test_for_win() === 0)
        update_on_move();
}

function simulate(steps) {
    steps.forEach(step => cell_click(step));
}

update_on_move();
let steps = Array.from(document.getElementById("steps").value.split(","));
simulate(steps);