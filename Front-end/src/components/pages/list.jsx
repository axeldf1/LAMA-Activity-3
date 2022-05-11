import React, {Component, useState} from "react";
import {Link} from "react-router-dom";
import { Grid, Segment } from 'semantic-ui-react';
import {User} from '../user/containers/User';
import {UserShortDisplay} from "../user/components/UserShortDisplay";
import {useDispatch} from "react-redux";
import axios from "axios";


export class ListCards extends Component {
    state = {
        cards: []
    }

    componentDidMount() {
        axios.get('http://localhost:8080/cards'
        ).then((result) => {
            setTimeout(()=>{
                const cards = result.data;
                this.setState( {cards})
                console.log(result)
            },1500)
        })
    }

    render() {
        return (
            <div className="ui grid">
                <div>
                    <h3 className="ui aligned header"> My Card List</h3>
                    <table className="ui fixed selectable single line celled table" id="cardListId">
                        <thead>
                        <tr>
                            <th className="three wide">Name</th>
                            <th className="three wide">Description</th>
                            <th>Family</th>
                            <th>HP</th>
                            <th>Energy</th>
                            <th>Defence</th>
                            <th>Attack</th>
                            <th>Price</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody id="tableContent">

                        {this.state.cards.map((card) => {
                            return(
                                <tr>
                                    <td>
                                        <img className="ui avatar image"/> <span>{card.name} </span>
                                    </td>
                                    <td>{card.description}</td>
                                    <td>{card.family}</td>
                                    <td>{card.hp}</td>
                                    <td>{card.energy}</td>
                                    <td>{card.defence}</td>
                                    <td>{card.attack}</td>
                                    <td>{card.price}$</td>
                                    <td>
                                        <div className="ui vertical animated button" tabIndex="0">
                                            <div className="hidden content">Sell</div>
                                            <div className="visible content">
                                                <i className="shop icon"></i>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            )})
                        }


                        </tbody>
                    </table>
                </div>

            </div>

        )
    }


}

