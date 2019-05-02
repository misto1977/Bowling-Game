import React, { Component } from 'react';
// components
import Button from "./Button";

class Buttons extends Component {

    handleClickEvent = (knockedPins) => {
      // send number of knocked pins to parent component
      this.props.onClickEvent(knockedPins);
    }

    render() {

      let pins = this.props.pins;
      const btns = [];
      for (let i = 0; i < pins + 1; i++) {
        btns.push(i);
      }

      return (
        <div className="btns">
          {btns.map( (button) =>
            <Button key={button} val={button} onClickEvent={this.handleClickEvent} />
          )}
        </div>
      )
    }

}

export default Buttons;
