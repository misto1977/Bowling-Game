import React, { Component } from 'react';

class FirstThrow extends Component {

  render() {
    return(
      <div className="fstThrow">
        <p>{this.props.knocked}</p>
      </div>
    )
  }
}

export default FirstThrow;
