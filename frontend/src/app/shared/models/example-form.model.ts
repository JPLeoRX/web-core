/**
 * Example Form
 *
 * Corresponds to ExampleFO in Java
 *
 * @author Leo Ertuna
 * @since 25.03.2018 18:51
 */
export class ExampleForm {
  private _text: string;

  constructor(text: string) {
    this._text = text;
  }

  get text(): string {
    return this._text;
  }
}
