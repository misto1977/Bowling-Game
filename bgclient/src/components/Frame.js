import React, { Component } from 'react';
import FirstThrow from "./FirstThrow";
import SecondThrow from "./SecondThrow";
import FrameResult from "./FrameResult";

class Frame extends Component {

  render() {
    return(
      <div className={"frame " + (this.props.active === this.props.id ? 'active' : 'inactive')} >
        <div class="id">{this.props.id}</div>

        <FirstThrow
          attempt={this.props.attempt}
          knocked={this.props.knocked} />
        <SecondThrow
          attempt={this.props.attempt}
          knocked={this.props.knocked} />
        <FrameResult
          attempt={this.props.attempt}
          result={0} />

      </div>
    )
  }
}

export default Frame;
