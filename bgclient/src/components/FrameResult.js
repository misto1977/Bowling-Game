import React, { Component } from 'react';

class FrameResult extends Component {

  render() {
    return(
      <div className="frameRes">
        {this.props.result}
      </div>
    )
  }
}

export default FrameResult;
