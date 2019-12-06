import React, { Component } from 'react';

const PlayersList = ({ players }) => {
    return (
        <div>
            <center><h1>Players List</h1></center>
            {players.map((player) => (
                <div class="card">
                    <div class="card-body">
                        <h5 class="card-title">{player.id}</h5>
                        <h6 class="card-subtitle mb-2 text-muted">{player.nick}</h6>
                        <p class="card-text">{player.email}</p>
                    </div>
                </div>
            ))}
        </div>
    )
};

export default PlayersList;