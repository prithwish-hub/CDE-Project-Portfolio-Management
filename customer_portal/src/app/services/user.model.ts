export class User {
  constructor(
    public userId: string,
    public username: string,
    public jwtToken: string,
    public serverCurrentTime: number,
    public tokenExpirationTime: number
  ) {}
}
