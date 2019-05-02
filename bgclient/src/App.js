import React, { Component } from 'react';
//import update from 'immutability-helper';
import './App.css';
import axios from 'axios';
import Buttons from './components/Buttons';
//import Fields from './components/Frames';
import Frames from './components/Frames';


class App extends Component {

  constructor(props) {
    super(props);

    this.state = {
      pins: 10,
      knockedPins: 0,
      attempt: 1,
      activeFrame: 1,
      frameRes: {
        1: 0,
        2: 0,
        3: 0,
        4: 0,
        5: 0,
        6: 0,
        7: 0,
        8: 0,
        9: 0,
        10: 0
      }
    };
  }

  handleClickEvent = (knockedPins) => {
    // pins are knocked, do something
    alert("You knocked down " + knockedPins + " pins!");

    // fetch the result from backend by sending number of knocked pins
    let score = null;
    fetch(`http://localhost:8080/roll?roll=${knockedPins}`)
      .then( res => res.json() )
      .then( res => score = res);

      if (this.state.attempt === 1) {
        this.setState({
          knockedPins: knockedPins,
          attempt: 2
        });
      } else {
        this.setState({
          knockedPins: knockedPins,
          attempt: 1,
          // Set frameRes for active frame to score returned from server
          frameRes: this.state.activeFrame + score,
          activeFrame: this.state.activeFrame + 1
        });
      }
  }

  startGame = () => {
    fetch('http://localhost:8080/start')
      .then(res => res.text())
      .then(res => alert(res))
  }

  render() {
    let pins = this.state.attempt === 1 ? this.state.pins : this.state.pins - this.state.knockedPins;

    return (
      <div className="App">
        <button onClick={this.startGame}>Start game</button>
        <Buttons
          onClickEvent={this.handleClickEvent}
          pins={pins} />
        <Frames
          attempt={this.state.attempt}
          active={this.state.activeFrame}
          knocked={this.state.knockedPins}
          frameRes={this.state.frameRes} />
      </div>
    );
  }
}

//Stateless component
function Frame(props) {
return <div>Frame {props.index}: {props.score}</div>; //Returns a div with information passed in with props
}

export default App;
