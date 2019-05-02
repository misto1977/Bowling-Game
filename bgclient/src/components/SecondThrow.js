import React, { Component } from 'react';

class SecondThrow extends Component {

  render() {
    return(
      <div className="sndThrow">
        <p>{this.props.knocked}</p>
      </div>
    )
  }
}

export default SecondThrow;
