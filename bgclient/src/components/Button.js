import React, { Component } from 'react';

class Button extends Component {

  handleClick = (event) => {
    const knockedPins = event.target.getAttribute('data-val');
    // send number of knocked pins to parent component
    this.props.onClickEvent(knockedPins);
  }

  render() {
    return(
      <div className="btn" data-val={this.props.val} onClick={this.handleClick}>
        {this.props.val}
      </div>
    )
  }
}

export default Button;
