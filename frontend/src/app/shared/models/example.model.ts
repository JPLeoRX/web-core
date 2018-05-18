/**
 * Example Model
 *
 * Corresponds to ExampleRO in Java
 *
 * @author Leo Ertuna
 * @since 24.03.2018 19:57
 */
export class Example {
  private _id: string;
  private _text: string;
  private _createdAt: number;

  constructor() {

  }

  get id(): string {
    return this._id;
  }

  get text(): string {
    return this._text;
  }

  get createdAt(): number {
    return this._createdAt;
  }

  set text(value: string) {
    this._text = value;
  }
}
