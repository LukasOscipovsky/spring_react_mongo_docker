import { AppBar, RaisedButton, TextField } from 'material-ui';
import * as React from 'react';

class LoginPage extends React.Component<any, any> {
    private signIn: VoidFunction;

    constructor(props: any) {
        super(props);

        this.signIn = () => this.handleClickSignIn()
    }

    public render() {
        return (
            <div className="form">
                <AppBar title="Login" />
                <TextField
                    hintText="Enter your username"
                    type="text"
                    floatingLabelText="Username"
                />
                <TextField
                    hintText="Enter your password"
                    floatingLabelText="Password"
                />
                <RaisedButton
                    onClick={this.signIn}
                    label="Sign In"
                />
            </div>
        );
    }

    private async handleClickSignIn() {
        alert('Logged successfully');
    }
}

export default LoginPage;